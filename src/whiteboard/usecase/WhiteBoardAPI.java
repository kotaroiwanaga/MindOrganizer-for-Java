package whiteboard.usecase;

import java.lang.*;

import javafx.scene.control.RadioButton;
import whiteboard.domain.*;

public interface WhiteBoardAPI
{
    public static void CreateUnit(UnitType type, Unit upperLayer) throws ClassNotFoundException {

        if(upperLayer == null)
        {
            return;
        }
        else if(upperLayer.GetType() == UnitType.Layer)
        {
            Unit unit = null;
            switch (type)
            {
                case Layer:
                    unit = new Layer();
                    break;
                case TextBox:
                    unit = new TextBox();
                    break;
                case CheckBox:
                    unit = new CheckBox();
                    break;
                case RadioButton:
                    // TODO: RadioButton作る
                case Table:
                    // TODO: Table作る
                case Link:
                    // TODO:Link作る
                case Image:
                    // TODO:Image作る
                default:
                    return;
            }
//                Class<?> unitClass = Class.forName(type.name());
//                Unit unit = (Unit)unitClass.newInstance();
            unit.SetUpperLayer(upperLayer);
            Layer layer = (Layer)upperLayer;
            layer.AddUnit(unit);
        }
    }
}
