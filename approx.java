package numerical_integrals;

public class Approx {
	private double a,b;//hranice integralu 
	private int limit;//kontrola
	private int max;//kolko * mozem max rozdelit interval
	//private static double s;
	public Approx(int a, int b, int max)
	{
		this.a=a;
		this.b=b;
		this.limit=0;
		this.max=max;
		//s=0;
	}
	public double rectangular(double left, double right, double suma, int limit)
	{
		double l, r, s;
		l=left;
		r=right;
		s=suma;
		System.out.println("iteracia: " + limit + " l: " + l + " r: " + r + " suma: " + s);
		if(limit<this.max) 
		{
			r=(l+r)/2;
			limit++;
			if(limit>3)//scitavame len najmensie intervaly
			{
				s=s+rectangular(l, r, s, limit);//vlavo
				l=r;//presunut na dalsi interval
				r*=2;//presunut na dalsi interval vpravo
				s=s+rectangular(l,r,s,limit);//vpravo
			}
			else
			{
				s=rectangular(l, r, s, limit);//vlavo
				l=r;//presunut na dalsi interval
				r*=2;//presunut na dalsi interval vpravo
				s=rectangular(l,r,s,limit);//vpravo
			}
			
			System.out.println("#####################");
			System.out.println("koniec intera s: " + s);
			System.out.println("#####################");
			return s;
		}
		//obsah obdlznika
		System.out.println("-----------------");
		System.out.println("navrat v iteracii: " + limit + " l: " + l + " r: " + r + " kalkulacia: "+
				((right-left)*(Math.sin((left+right)/2))/(Math.log10((left+right)/2))) + " s: "+
				s
		+ " sum: " + (s+((right-left)*(Math.sin((left+right)/2))/(Math.log10((left+right)/2)))));
		System.out.println("-----------------");
		return ((right-left)*(Math.sin((left+right)/2))/(Math.log10((left+right)/2)));
	}
}
