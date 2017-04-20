package ua.training;

public class Model {

    int value;
    int maxLimit;
    int minLimit;

    public Model() {
        this.maxLimit = GlobalConstant.maxLimit;
        this.minLimit = GlobalConstant.minLimit;
        setRandomValue();
    }

    public void setRandomValue(){
        setValue(minLimit+(int) (Math.random()*maxLimit));
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Integer maxLimit) {
        this.maxLimit = maxLimit;
    }

    public Integer getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }
}
