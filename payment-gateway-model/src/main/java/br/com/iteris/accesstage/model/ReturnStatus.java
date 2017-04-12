package br.com.iteris.accesstage.model;

import br.com.iteris.accesstage.model.primitives.Message;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ReturnStatus {

    @JsonUnwrapped
    private ReturnCode returnCode;

    @JsonUnwrapped
    private Message returnMessage;

    @JsonCreator
    public ReturnStatus(@JsonProperty("returnCode") ReturnCode returnCode, @JsonProperty("returnMessage") String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = new Message(returnMessage);
    }

    public static ReturnStatus nok() {
        return new ReturnStatus(ReturnCode.NOK, "ERROR");
    }

    public static ReturnStatus ok() {
        return new ReturnStatus(ReturnCode.OK, "Success");
    }

    public static ReturnStatus unauthorized() {
        return new ReturnStatus(ReturnCode.UNAUTHORIZED, "Unauthorized");
    }

    public boolean is(ReturnCode returnCode) {
        return this.returnCode.equals(returnCode);
    }

    @Override
    public String toString() {
        return "{" +
            "returnCode=" + returnCode +
            ", returnMessage=" + returnMessage +
            '}';
    }
}
