package com.marceloluiz.Pokedex.services;

public interface IConvertData {
	<T> T getData(String json, Class<T> javaClass);
}
