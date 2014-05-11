package no.pdigre.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import no.pdigre.pSQT.ERow;
import no.pdigre.pSQT.FDescription;
import no.pdigre.pSQT.MRow;
import no.pdigre.pSQT.PSQTPackage;
import no.pdigre.pSQT.Row;
import no.pdigre.pSQT.Row1;
import no.pdigre.pSQT.TDescription;
import no.pdigre.services.PSQTGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class PSQTSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PSQTGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == PSQTPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case PSQTPackage.EROW:
				if(context == grammarAccess.getERowRule()) {
					sequence_ERow(context, (ERow) semanticObject); 
					return; 
				}
				else break;
			case PSQTPackage.FDESCRIPTION:
				if(context == grammarAccess.getFDescriptionRule()) {
					sequence_FDescription(context, (FDescription) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getModelRule()) {
					sequence_FDescription_Model(context, (FDescription) semanticObject); 
					return; 
				}
				else break;
			case PSQTPackage.MROW:
				if(context == grammarAccess.getMRowRule()) {
					sequence_MRow(context, (MRow) semanticObject); 
					return; 
				}
				else break;
			case PSQTPackage.ROW:
				if(context == grammarAccess.getRowRule()) {
					sequence_Row(context, (Row) semanticObject); 
					return; 
				}
				else break;
			case PSQTPackage.ROW1:
				if(context == grammarAccess.getRow1Rule()) {
					sequence_Row1(context, (Row1) semanticObject); 
					return; 
				}
				else break;
			case PSQTPackage.TDESCRIPTION:
				if(context == grammarAccess.getTDescriptionRule()) {
					sequence_TDescription(context, (TDescription) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTableRule()) {
					sequence_TDescription_Table(context, (TDescription) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=Row1
	 */
	protected void sequence_ERow(EObject context, ERow semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PSQTPackage.Literals.EROW__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PSQTPackage.Literals.EROW__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getERowAccess().getNameRow1ParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID base=INT mgl=INT egl=INT)
	 */
	protected void sequence_FDescription(EObject context, FDescription semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID base=INT mgl=INT egl=INT tables+=Table*)
	 */
	protected void sequence_FDescription_Model(EObject context, FDescription semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=Row1
	 */
	protected void sequence_MRow(EObject context, MRow semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PSQTPackage.Literals.MROW__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PSQTPackage.Literals.MROW__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMRowAccess().getNameRow1ParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         c+=INT 
	 *         c+=INT 
	 *         c+=INT 
	 *         c+=INT 
	 *         c+=INT 
	 *         c+=INT 
	 *         c+=INT 
	 *         c+=INT
	 *     )
	 */
	protected void sequence_Row1(EObject context, Row1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=RowLabel m=MRow e=ERow)
	 */
	protected void sequence_Row(EObject context, Row semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PSQTPackage.Literals.ROW__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PSQTPackage.Literals.ROW__NAME));
			if(transientValues.isValueTransient(semanticObject, PSQTPackage.Literals.ROW__M) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PSQTPackage.Literals.ROW__M));
			if(transientValues.isValueTransient(semanticObject, PSQTPackage.Literals.ROW__E) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PSQTPackage.Literals.ROW__E));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRowAccess().getNameRowLabelParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getRowAccess().getMMRowParserRuleCall_1_0(), semanticObject.getM());
		feeder.accept(grammarAccess.getRowAccess().getEERowParserRuleCall_2_0(), semanticObject.getE());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=PieceType mg=INT eg=INT)
	 */
	protected void sequence_TDescription(EObject context, TDescription semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=PieceType 
	 *         mg=INT 
	 *         eg=INT 
	 *         r+=Row 
	 *         r+=Row 
	 *         r+=Row 
	 *         r+=Row 
	 *         r+=Row 
	 *         r+=Row 
	 *         r+=Row 
	 *         r+=Row
	 *     )
	 */
	protected void sequence_TDescription_Table(EObject context, TDescription semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
