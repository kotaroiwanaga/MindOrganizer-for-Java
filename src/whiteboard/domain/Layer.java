package whiteboard.domain;

import javax.swing.*;
import java.util.*;

import static java.lang.System.*;

public class Layer implements Unit
{
    private List<Unit> underLayers;
    private Layer upperLayer; // 親のUnitはLayerでないといけない
    private JPanel jPanel;

    public Layer()
    {
        this.upperLayer = null;
        this.jPanel = new JPanel();
        this.underLayers = new ArrayList<Unit>();
    }

    public UnitType GetType()
    {
        return UnitType.Layer;
    }

    public int GetLayerLevel()
    {
        if(upperLayer == null)
        {
            return 0;
        }
        else
        {
            return upperLayer.GetLayerLevel() + 1;
        }
    }

    public JComponent GetComponent()
    {
        return this.jPanel;
    }

    public void ClearUpperLayer()
    {
        this.upperLayer = null;
    }

    public void SetUpperLayer(Unit layer)
    {
        // TODO:layerがLayer型であることのチェック
        this.upperLayer = (Layer) layer;
    }

    public Layer GetUpperLayer()
    {
        return this.upperLayer;
    }

    public void Print()
    {
        int layerLevel = this.GetLayerLevel();
        String space = String.join("", Collections.nCopies(layerLevel, "    "));
        out.println(space + "LayerLevel : " + layerLevel);

        for (Unit unit:this.underLayers)
        {
            unit.Print();
        }
    }

    public int GetUnderLayersSize()
    {
        return this.underLayers.size();
    }

    public void AddUnit(Unit unit, int idx)
    {
        // TODO: idxの値チェック
        // 本当はエラーコード返すとかやったほうがいい
        if(unit != null)
        {
            unit.SetUpperLayer(this);
            this.underLayers.add(idx, unit);
        }
    }

    public void AddUnit(Unit unit)
    {
        int idx = this.GetUnderLayersSize();
        this.AddUnit(unit, idx);
    }

    public Unit GetUnit(int idx)
    {
        // TODO: idxの値チェック
        return this.underLayers.get(idx);
    }

    public Unit TakeUnit(int idx)
    {
        // TODO: idxの値チェック
        Unit unit = this.underLayers.get(idx);
        this.underLayers.remove(idx);
        unit.ClearUpperLayer();
        return unit;
    }

    public void DeleteUnit(int idx)
    {
        // 本当はエラーコード返すとかやったほうがいい
        if(idx >= 0&& idx < this.underLayers.size())
        {
            this.underLayers.remove(idx);
        }
    }

    public void ClearUnderLayers()
    {
        this.underLayers.clear();
    }

    public void SortUnits(Comparator<Unit> unitComparator)
    {
        this.underLayers.sort(unitComparator);
    }
}
