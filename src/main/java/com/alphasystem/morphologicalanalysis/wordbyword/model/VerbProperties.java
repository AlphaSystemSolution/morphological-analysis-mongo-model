/**
 * 
 */
package com.alphasystem.morphologicalanalysis.wordbyword.model;

import com.alphasystem.arabic.model.ArabicWord;
import com.alphasystem.morphologicalanalysis.wordbyword.model.support.ConversationType;
import com.alphasystem.morphologicalanalysis.wordbyword.model.support.VerbMode;
import com.alphasystem.morphologicalanalysis.wordbyword.model.support.VerbType;
import org.springframework.data.annotation.Transient;

import static com.alphasystem.arabic.model.ArabicWord.concatenateWithSpace;
import static com.alphasystem.morphologicalanalysis.wordbyword.model.support.ConversationType.THIRD_PERSON;
import static com.alphasystem.morphologicalanalysis.wordbyword.model.support.VerbType.PERFECT;

/**
 * @author sali
 * 
 */
public class VerbProperties extends AbstractProperties {

	private static final long serialVersionUID = 579863620988819896L;

	protected ConversationType conversationType;

	protected VerbType verbType;

	protected VerbMode mode;

	public VerbProperties() {
		super();
		setVerbType(null);
		setMode(null);
		setConversationType(null);
	}

	/**
	 * @param src
	 * @throws NullPointerException
	 */
	public VerbProperties(VerbProperties src) throws NullPointerException {
		super(src);
		setVerbType(src.getVerbType());
		setMode(src.getMode());
		setConversationType(src.getConversationType());
	}

	public ConversationType getConversationType() {
		return conversationType;
	}

	public void setConversationType(ConversationType conversationType) {
		this.conversationType = conversationType == null ? THIRD_PERSON
				: conversationType;
	}

	@Override
	@Transient
	public ArabicWord getLabel() {
		return concatenateWithSpace(gender.getLabel(),
				conversationType.getLabel(), number.getLabel());
	}

	public VerbMode getMode() {
		return mode;
	}

	public void setMode(VerbMode mode) {
		this.mode = mode;
	}

	public VerbType getVerbType() {
		return verbType;
	}

	public void setVerbType(VerbType verbType) {
		this.verbType = verbType == null ? PERFECT : verbType;
	}

	public VerbProperties withConversationType(ConversationType conversationType) {
		setConversationType(conversationType);
		return this;
	}

	public VerbProperties withVerbMode(VerbMode verbMode) {
		setMode(verbMode);
		return this;
	}

	public VerbProperties withVerbType(VerbType verbType) {
		setVerbType(verbType);
		return this;
	}
}
