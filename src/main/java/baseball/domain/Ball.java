package baseball.domain;

public class Ball {

	private final int ballNumber;
	private final int ballIndex;


	public Ball(int ballNumber, int ballIndex) {
		validateBall(ballNumber, ballIndex);
		this.ballNumber = ballNumber;
		this.ballIndex = ballIndex;
	}

	private void validateBall(int ballNumber, int ballIndex) {
		validateBallNumber(ballNumber);
		validateBallIndex(ballIndex);
	}

	private void validateBallNumber(int ballNumber) {
		if (ballNumber < Constants.MIN_NUMBER || ballNumber > Constants.MAX_NUMBER) {
			throw new IllegalArgumentException("야구공의 숫자는 1~9 사이의 숫자입니다.");
		}
	}

	private void validateBallIndex(int ballIndex) {
		if (ballIndex >= Constants.NUMBER_SIZE || ballIndex < 0) {
			throw new IllegalArgumentException("야구공의 인덱스는 0~2 사이의 숫자입니다.");
		}
	}

	public BallStatus compare(Ball otherBall) {
		if (this.equals(otherBall)) {
			return BallStatus.STRIKE;
		}
		if (this.ballNumber == otherBall.ballNumber) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	@Override
	public boolean equals(Object obj) {
		if (!obj.getClass().isAssignableFrom(Ball.class)) {
			return false;
		}
		Ball otherBall = (Ball) obj;
		return this.ballNumber == otherBall.ballNumber && this.ballIndex == otherBall.ballIndex;
	}
}
