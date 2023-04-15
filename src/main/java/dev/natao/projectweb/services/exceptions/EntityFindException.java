package dev.natao.projectweb.services.exceptions;

public class EntityFindException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EntityFindException (Object id) {
		super("Entity not found. ID: " + id);
	}
}
