package top.geminix.circle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfo {
    private String adminId;
    private String adminName;
    private String adminPassword;
    private String adminTelephone;

}
