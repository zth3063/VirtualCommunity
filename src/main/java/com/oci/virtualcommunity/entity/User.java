package com.oci.virtualcommunity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Table(name="user")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String code;
    @NotBlank(message = "名称不能为空")
    private String userName;
    @Size(min = 6,max = 20,message = "密码长度要求大于6小于20")
    private String password;
    @NotBlank(message = "职位不能为空")
    private String position;
}
