package nz.co.fitnet.numberGenerator.api;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

@Service
public interface NumberService {
	int rollDie(int sides);

	double rollGaussianNumber(double max);

	List<Integer> rollDice(int sides, int times);

	double numberBetween(int min, int max);

	double gaussianNumberBetween(double min, double max);

	double gaussianNumber();
}
