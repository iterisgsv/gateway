package br.com.iteris.accesstage.model;

import javax.persistence.Convert;
import javax.persistence.Embedded;

import br.com.iteris.accesstage.model.converter.ReturnCodeConverter;
import br.com.iteris.accesstage.model.primitives.Message;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ReturnStatus {

    @JsonUnwrapped
    @Convert(converter = ReturnCodeConverter.class)
    private ReturnCode returnCode;

    @JsonUnwrapped
    @Embedded
    private Message returnMessage;

    public ReturnStatus() { }

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
