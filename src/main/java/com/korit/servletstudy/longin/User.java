package com.korit.servletstudy.longin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String userName;
    private String password;
    private String name;
}
