package pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author houyl
 * @description
 * @since 2019/8/31 14:53
 */
@Data
@ToString
public class Employee {
    private Integer id;
    private String empName;
    private Integer gender;
    private String email;

}
