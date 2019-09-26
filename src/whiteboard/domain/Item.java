package whiteboard.domain;

public abstract class Item implements Unit
{
    // フィールド
    private Unit upperLayer; // 今後の拡張(Table)のためにLayerでなくUnitとする

    // メソッド
    public int GetLayerLevel()
    {
        return upperLayer.GetLayerLevel() + 1;
    }

    public Unit GetUpperLayer()
    {
        return upperLayer;
    }

    public void ClearUpperLayer()
    {
        this.upperLayer = null;
    }

    public void SetUpperLayer(Unit unit)
    {
        // TODO:unitのNULLチェック
        this.upperLayer = unit;
    }
}



