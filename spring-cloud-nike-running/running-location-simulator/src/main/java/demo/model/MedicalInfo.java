package demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicalInfo {
    private long medicalInfoId;
    private String bandMake;
    private String medicalInfoClassification;
    private String description;
    private String aidInstructions;

    public MedicalInfo() {

    }
}
