import java.util.Arrays;
import Jama.Matrix;
import javax.swing.JOptionPane;

public class FatPointMatrix 
{
	private double[][] partials;
	private int numPartials;
	private double[][] monomials;
	private int numMonomials;
	private double[][] matrix;
	private static double[][] coeffs;
	static Combinatorics combinatorics = new Combinatorics();
	
	public static void initializeCoeffs(int n, int d)
	{
		FatPointMatrix.coeffs = combinatorics.comb(d, n + 1);
	}
	
	public FatPointMatrix(int n, int d, int m)
	{
		this(n, d, m, FatPointMatrix.coeffs);
	}
	
	public FatPointMatrix(int n, int d, int m, double[][] coeffs)
	{
		this.monomials = coeffs;
		this.numMonomials = coeffs.length;
		
		this.partials = combinatorics.comb(m - 1, n + 1);
		this.numPartials = this.partials.length;
		this.monomials = combinatorics.comb(d, n + 1);
		this.numMonomials = this.monomials.length;
		this.matrix = new double[this.numPartials][this.numMonomials];
		
		for(int i = 0; i < this.partials.length; i++)
		{
			for(int j = 0; j < this.monomials.length; j++)
			{
				this.matrix[i][j] = matrixEntries(partials[i], monomials[j]); 
			}
		}
	}
	
	public FatPointMatrix() {
		// TODO Auto-generated constructor stub
	}

	private double derivativeCoefficient(double partials2, double monomials2)
	{
		if(monomials2 < partials2)
		{
			return 0;
		}
		
		double i = 1.0;
		
		double p = monomials2 - partials2 + 1.0;
		
		while(p <= monomials2)
		{
			i *= (p++);
		}
		
		return i;
		//return (int) (Combinatorics.factorial(monomials2)/(Combinatorics.factorial(monomials2 - partials2)));
	}
	
	private double matrixEntries(double[] partials2, double[] monomials2)
	{
		double[] coefficients = new double[monomials2.length];
		
		for(int i = 0; i < coefficients.length; i++)
		{
			coefficients[i] = derivativeCoefficient(partials2[i], monomials2[i]);
		}
		
		double product = 1.0;
		
		for(int i = 0; i < coefficients.length; i++)
		{
			product *= coefficients[i];
		}
		
		return product;
	}
	
	public double[] dimensions()
	{
		return new double[]{this.partials.length, this.monomials.length};
	}
	
	public double[][] getPartials()
	{
		return this.partials;
	}
	
	public double[][] getMonomials()
	{
		return this.monomials;
	}
	
	public double[][] matrix()
	{
		return this.matrix;
	}
	
	public boolean hasFullRank()
	{
		Matrix A = new Matrix(this.matrix);
		
		return A.rank() == Math.min(this.matrix.length, this.matrix[0].length);
	}
	
	private void test()
	{
		System.out.println("Partials:");
		for(int j = 0; j < this.partials.length; j++)
		{
			System.out.println(Arrays.toString(this.partials[j]));
		}
		System.out.println();
		
		System.out.println("Monomials:");
		for(int j = 0; j < this.monomials.length; j++)
		{
			System.out.println(Arrays.toString(this.monomials[j]));
		}
		System.out.println();
		
		System.out.println("Matrix:");
		for(int i = 0; i < this.matrix.length; i++)
		{
			System.out.println(Arrays.toString(this.matrix[i]));
		}
	}
	
	public static void main(String[] args)
	{
		
		JOptionPane.showMessageDialog(null, "Welcome to a special Math 400 Dr. Paul and Shubham Kahal production!", "Welcome", JOptionPane.PLAIN_MESSAGE);
		
		String n = JOptionPane.showInputDialog("Enter a n value: ");
		String d = JOptionPane.showInputDialog("Enter a d value: ");
		String m = JOptionPane.showInputDialog("Enter a m value: ");
		int nNum = Integer.parseInt(n);
		int dNum = Integer.parseInt(d);
		int mNum = Integer.parseInt(m);
		
		JOptionPane.showMessageDialog(null, "n: " + nNum + " d: " + dNum + " m: " + mNum, "FatPointMatrix", JOptionPane.PLAIN_MESSAGE);
		
		initializeCoeffs(nNum, dNum);
		FatPointMatrix fatPointMatrix = new FatPointMatrix(nNum, dNum, mNum);
		
		String partialsString = "";
		for(int j = 0; j < fatPointMatrix.partials.length; j++)
		{
			partialsString += Arrays.toString(fatPointMatrix.partials[j]) + "\n";
		}
		
		JOptionPane.showMessageDialog(null, partialsString, "Partials", JOptionPane.PLAIN_MESSAGE);
		
		String monomialsString = "";
		for(int j = 0; j < fatPointMatrix.monomials.length; j++)
		{
			monomialsString += Arrays.toString(fatPointMatrix.monomials[j]) + "\n";
		}
		
		JOptionPane.showMessageDialog(null, monomialsString, "Monomials", JOptionPane.PLAIN_MESSAGE);
		
		String matrixString = "";
		for(int i = 0; i < fatPointMatrix.matrix.length; i++)
		{
			matrixString += Arrays.toString(fatPointMatrix.matrix[i]) + "\n";
		}
		
		JOptionPane.showMessageDialog(null, matrixString, "Matrix", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "Matrix has full rank: " + fatPointMatrix.hasFullRank(), "Full Rank Test", JOptionPane.PLAIN_MESSAGE);
	
	}
}
