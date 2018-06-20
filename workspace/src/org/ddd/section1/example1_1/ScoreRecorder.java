package org.ddd.section1.example1_1;

public class ScoreRecorder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	private float c(float a[],int b[])
	{
		float  d = 0,e = 0;
		int f = 0; 
		float  s = 0; 
		
		for(int i = 0; i<a.length; i++)
		{
			if( b[i] == 2)
			{
				a[i] = a[i] * 1.1f; 
			}
			
			if(d < a[i])
			{
				d = a[i];
			}
			if(e > a[i])
			{
				e = a[i];
			}			
		}

		for(int i = 0; i<a.length; i++)
		{
			if(a[i] != d && a[i] != e)
			{
				 f++;
				 s = s + a[i]; 
			}			 
		} 		
		return s / f  ;
	}
	public final static int SENIOR_JUDAGE = 2;
	public final static float SENIOR_JUDAGE_WEIGHT = 1.1f;
	private float calculateAvgActualScore(float rawScores[],int judgeLevels[])
	{
		float actualScores[] = calculateActualScores(rawScores,judgeLevels);
		
		float avgActualScore = calculateAvgScore(actualScores);
		
		return  avgActualScore ;
	}
	private float[] calculateActualScores(float rawScores[],int judgeLevels[])
	{
 
		float actualScores[] = new float[rawScores.length];
		
		for(int i = 0; i<rawScores.length; i++)
		{
			if( judgeLevels[i] == ScoreRecorder.SENIOR_JUDAGE)
			{
				actualScores[i] = rawScores[i] * ScoreRecorder.SENIOR_JUDAGE_WEIGHT; 
			}	
			else
			{
				actualScores[i] = rawScores[i];
			}
 			
		}
 		
		return  actualScores ;
	}
	private float calculateAvgScore(float scores[])
	{ 
		float  maxScore = 0;
		float minScore = 0;
		
		for(int i = 0; i<scores.length; i++)
		{
			if(maxScore < scores[i])
			{
				maxScore = scores[i];
			}
			if(minScore > scores[i])
			{
				minScore = scores[i];
			}			
		}

		int validScoreCount = 0; 
		float  sumScore = 0; 
		for(int i = 0; i<scores.length; i++)
		{
			if(scores[i] != maxScore && scores[i] != minScore)
			{
				validScoreCount++;
				 sumScore = sumScore + scores[i]; 
			}			 
		} 
		
		float avgScore = sumScore / validScoreCount;
		
		return  avgScore ;
	}
	
	private float calculateAvgScore(float rawScores[],int judgeLevels[])
	{
		float  maxScore = 0;
		float minScore = 0;
		float actualScores[] = new float[rawScores.length];
		
		for(int i = 0; i<rawScores.length; i++)
		{
			if( judgeLevels[i] == ScoreRecorder.SENIOR_JUDAGE)
			{
				actualScores[i] = rawScores[i] * ScoreRecorder.SENIOR_JUDAGE_WEIGHT; 
			}		
			else
			{
				actualScores[i] = rawScores[i] ;
			}
			if(maxScore < actualScores[i])
			{
				maxScore = actualScores[i];
			}
			if(minScore > actualScores[i])
			{
				minScore = rawScores[i];
			}			
		}

		int validScoreCount = 0; 
		float  sumScore = 0; 
		for(int i = 0; i<actualScores.length; i++)
		{
			if(actualScores[i] != maxScore && actualScores[i] != minScore)
			{
				validScoreCount++;
				 sumScore = sumScore + actualScores[i]; 
			}			 
		} 
		
		float avgScore = sumScore / validScoreCount;
		
		return  avgScore ;
	}
}
