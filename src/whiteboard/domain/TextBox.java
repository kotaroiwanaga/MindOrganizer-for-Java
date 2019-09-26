package whiteboard.domain;

import javax.swing.*;

import java.util.Collections;

import static java.lang.System.*;

public class TextBox extends Item
{
    // フィールド
    private JTextArea jTextArea;

    // メソッド
    public TextBox(Unit upperLayer, String text)
    {
        // TODO: upperLayerのNULLチェック
        // TODO: textのNULLチェック
        this.jTextArea = new JTextArea();
        this.jTextArea.setText(text);
    }

    public TextBox(String text)
    {
        this(null, text);
    }

    public TextBox()
    {
        this(null, "");
    }

    public UnitType GetType()
    {
        return UnitType.TextBox;
    }

    public void Print()
    {
        int layerLevel = this.GetLayerLevel();
        String space = String.join("", Collections.nCopies(layerLevel, "    "));
        out.println(space + this.GetType() + " : " + this.jTextArea.getText());
    }

    public JComponent GetComponent()
    {
        return this.jTextArea;
    }
}
