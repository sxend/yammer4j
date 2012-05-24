package yammer4j.messages;

public final class MessagesFactory {
	public static final Messages init() {
		return new MessagesImpl();
	}
}
