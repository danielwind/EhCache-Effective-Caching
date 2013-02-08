package net.danielwind.effcaching.chapter8.exceptions;

public final class CacheServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_MESSAGE = "EhCache Server Failed Response, HTTP Code: ";

	public CacheServerException(String message) {
		super(DEFAULT_MESSAGE + message);
	}

	public CacheServerException(Throwable cause) {
		super(cause);
	}

	public CacheServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CacheServerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
