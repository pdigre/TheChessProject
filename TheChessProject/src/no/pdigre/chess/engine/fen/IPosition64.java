package no.pdigre.chess.engine.fen;

public interface IPosition64 extends IPosition {

	long get64black();

	long get64bit1();

	long get64bit2();

	long get64bit3();

	@Override
	public IPosition64 move(long bitmap);

	boolean isCheckWhite();

	boolean isCheckBlack();

}
