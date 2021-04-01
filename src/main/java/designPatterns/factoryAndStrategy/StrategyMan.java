package designPatterns.factoryAndStrategy;

public enum StrategyMan {
    SteadyDeduction("designPatterns.factoryAndStrategy.SteadyDeduction"),
    FreeDeduction("designPatterns.factoryAndStrategy.FreeDeduction");
    String value = "";
    private StrategyMan(String _value){
        this.value = _value;
    }
    public String getValue(){
        return this.value;
    }
}
