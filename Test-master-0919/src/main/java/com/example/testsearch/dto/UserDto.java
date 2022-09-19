package com.example.testsearch.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDto {

        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        @Size(min = 5, max = 512)
        private String useremail;

        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        @Size(min = 8, max = 512)
        private String userpw;


        @NotBlank(message = "이름은 필수 입력 값입니다.")
        @Size(min = 2, max = 512)
        private String username;

        @NotNull(message = "전화번호를 입력해주세요.")
        @Size(min = 2, max = 512)
        private String phone;

        private LocalDateTime regdate;

        private LocalDateTime logindate;

        private LocalDateTime moddate;

        private String enabled;

        private String userId;



        public String getUseremail() {
            return useremail;
        }

        public void setUseremail(String useremail) {
            this.useremail = useremail;
        }

        public String getUserpw() {
            return userpw;
        }

        public void setUserpw(String userpw) {
            this.userpw = userpw;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public LocalDateTime getRegdate() {
            return regdate;
        }

        public void setRegdate(LocalDateTime regdate) {
            this.regdate = regdate;
        }

        public LocalDateTime getLogindate() {
            return logindate;
        }

        public void setLogindate(LocalDateTime logindate) {
            this.logindate = logindate;
        }

        public LocalDateTime getModdate() {
            return moddate;
        }

        public void setModdate(LocalDateTime moddate) {
            this.moddate = moddate;
        }

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterForm{");
        sb.append("useremail='").append(useremail).append('\'');
        sb.append(", userpw='").append(userpw).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", regdate=").append(regdate);
        sb.append(", logindate=").append(logindate);
        sb.append(", moddate=").append(moddate);
        sb.append(", enabled=").append(enabled);
        sb.append('}');
        return sb.toString();
    }


}
