package whiteboard.app;

import whiteboard.domain.Layer;
import whiteboard.domain.Unit;
import whiteboard.domain.UnitType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static whiteboard.usecase.WhiteBoardAPI.CreateUnit;

public class GUIForm {
    private JFrame mainFrame;
    private Layer whiteBoard;
    private JPanel panel1;//TODO: 消したいのに消せない


    public GUIForm(Layer whiteBoard)
    {
        this.whiteBoard = whiteBoard;
        InitMainFrame();
        InitLeftPanel();
        SetWhiteBored(this.whiteBoard);
    }

    private void InitMainFrame()
    {
        this.mainFrame = new JFrame();
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 表示場所の設定
        mainFrame.setLocationByPlatform(true);

        // タイトル
        mainFrame.setTitle("Thought Organization Tool");

        // アイコン
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image icon = tk.getImage("C:\\Study\\Java_Practice\\img\\icon1.gif");
        mainFrame.setIconImage(icon);

        mainFrame.setVisible(true);
    }

    // メインフォーム左側のUnitメニューの設定
    private void InitLeftPanel()
    {
        JPanel leftPanel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS);
        leftPanel.setLayout(boxLayout);

        UnitType unitTypes[] = {
                UnitType.Layer,
                UnitType.TextBox,
                UnitType.CheckBox,
                UnitType.RadioButton,
                UnitType.Table,
                UnitType.Layer,
                UnitType.Image
        };
        for(int i = 0; i < unitTypes.length; i++)
        {
            JButton button = new JButton(unitTypes[i].name());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton clickedButton = (JButton) actionEvent.getSource();
                    try {
                        CreateUnit(UnitType.valueOf(clickedButton.getText()), whiteBoard);
                        SetWhiteBored(whiteBoard);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            leftPanel.add(button);
        }

        for(int i = 0; i < unitTypes.length; i++)
        {
            leftPanel.getComponent(i);
        }

        mainFrame.add(leftPanel, BorderLayout.WEST);

    }

    private void SetWhiteBored(Unit unit)
    {
        UnitType type = unit.GetType();

        switch (type)
        {
            case Layer:
                Layer layer = (Layer)unit;
                JPanel jPanel = (JPanel) layer.GetComponent();
                String panelTitle;

                jPanel.setLayout(new FlowLayout());

                if(layer.GetUpperLayer() == null)
                {
                    panelTitle = "ホワイトボード";
                    this.mainFrame.add(jPanel, BorderLayout.CENTER);
                }
                else
                {
                    panelTitle = "第"+ unit.GetLayerLevel() +"層";
                    this.ConnectUpperComponent(unit);
                }

                // パネルの枠線とタイトルを表示
                Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
                TitledBorder titledBorder = BorderFactory.createTitledBorder(lineBorder, panelTitle);
                jPanel.setBorder(titledBorder);


                for (int i = 0; i < layer.GetUnderLayersSize(); i++)
                {
                    this.SetWhiteBored(layer.GetUnit(i));
                }
                break;
            default:
                this.ConnectUpperComponent(unit);
                break;
        }
    }

    // 親コンポーネントに所属させる
    private void ConnectUpperComponent(Unit unit)
    {
        JComponent upperComponent = unit.GetUpperLayer().GetComponent();
        JComponent jComponent = unit.GetComponent();
        upperComponent.add(jComponent, BorderLayout.NORTH);
    }

}
