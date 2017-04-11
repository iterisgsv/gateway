package br.com.iteris.accesstage.model;

import br.com.iteris.accesstage.model.primitives.Message;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ReturnStatus {

    @JsonUnwrapped
    private ReturnCode returnCode;

    @JsonUnwrapped
    private Message returnMessage;

    public ReturnStatus(ReturnCode returnCode, Message returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public ReturnStatus() { }
}