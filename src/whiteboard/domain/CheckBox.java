package whiteboard.domain;

import javax.swing.*;
import java.util.Collections;

import static java.lang.System.out;

public class CheckBox extends Item
{
    // フィールド
    private JCheckBox jCheckBox;
    private Layer upperLayer;

    // メソッド
    public CheckBox(String text)
    {
        text = text != null? text : "";
        this.jCheckBox = new JCheckBox(text);
    }

    public CheckBox()
    {
        this("");
    }

    public UnitType GetType()
    {
        return UnitType.CheckBox;
    }

    public void Print()
    {
        int layerLevel = this.GetLayerLevel();
        String space = String.join("", Collections.nCopies(layerLevel, "    "));
        out.println(space + this.GetType() + " : " + this.GetText() + " (" + this.GetIsSelected() + ")");
    }

    public JComponent GetComponent()
    {
        return this.jCheckBox;
    }

    public boolean GetIsSelected()
    {
        return this.jCheckBox.isSelected();
    }

    public void SetText(String text)
    {
        this.jCheckBox.setText(text);
    }

    public String GetText()
    {
        return this.jCheckBox.getText();
    }
}
