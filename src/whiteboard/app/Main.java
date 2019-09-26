package whiteboard.app;

import whiteboard.app.GUIForm;
import whiteboard.domain.*;

public class Main {

    public static void main(String[] args)
    {
        Layer whiteBorad = new Layer();
//        whiteBorad.AddUnit(new TextBox("aaaa"));
//
//        Unit checkBox1 = new CheckBox("xxxx");
//
//        whiteBorad.AddUnit(checkBox1, 0);
//
//        Layer layer1 = new Layer();
//        layer1.AddUnit(new Layer());
//        layer1.AddUnit(new TextBox("bbbb"));
//        whiteBorad.AddUnit(layer1);
//
//        for(int i = 0; i < layer1.GetUnderLayersSize(); i++)
//        {
//            Unit tmpUnit = layer1.GetUnit(i);
//            if(tmpUnit.GetType() == UnitType.Layer)
//            {
//                Layer tmpLayer = (Layer)tmpUnit;
//                tmpLayer.AddUnit(new TextBox("yyyy"));
//            }
//        }
//
//        whiteBorad.AddUnit(new TextBox("cccc"));
//        whiteBorad.AddUnit(new Layer());

        whiteBorad.Print();

        GUIForm form = new GUIForm(whiteBorad);

    }
}
