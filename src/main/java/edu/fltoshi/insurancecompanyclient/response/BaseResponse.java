package edu.fltoshi.insurancecompanyclient.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseResponse {
    protected boolean success;
    protected String message;
}
