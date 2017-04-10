package br.com.iteris.accesstage.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionResponse {

    @Getter
    @NonNull
    private Greeter greeter;
}
