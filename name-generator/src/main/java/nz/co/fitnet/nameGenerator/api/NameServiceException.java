package nz.co.fitnet.nameGenerator.api;

public class NameServiceException extends Exception {

	private static final long serialVersionUID = -5935249950870127082L;

	public NameServiceException(final String message) {
		super(message);
	}

	public NameServiceException(final Throwable cause) {
		super(cause);
	}

	public NameServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NameServiceException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
