package whiteboard.domain;


import javax.swing.*;

public interface Unit
{
    public UnitType GetType();
    public int GetLayerLevel();
    public void SetUpperLayer(Unit unit);
    public Unit GetUpperLayer();
    public void ClearUpperLayer();
    public void Print();
    public JComponent GetComponent();
}
