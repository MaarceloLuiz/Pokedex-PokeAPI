package com.marceloluiz.Pokedex.services.converters;

public interface IConvertData {
	<T> T getData(String json, Class<T> javaClass);
}
