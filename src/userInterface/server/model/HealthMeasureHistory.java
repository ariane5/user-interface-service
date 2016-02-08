package userInterface.server.model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bishruti on 2/6/16.
 */
public class HealthMeasureHistory implements Serializable {

    private int hmhId;
    @Temporal(TemporalType.DATE)
    private Date dateRegistered;
    private String measureType;
    private String measureValue;
    private String measureValueType;

    public int getHmhId() {
        return hmhId;
    }

    public void setHmhId(int hmhId) {
        this.hmhId = hmhId;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public String getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(String measureValue) {
        this.measureValue = measureValue;
    }

    public String getMeasureValueType() {
        return measureValueType;
    }

    public void setMeasureValueType(String measureValueType) {
        this.measureValueType = measureValueType;
    }
}
