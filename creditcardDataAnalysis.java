package creditcard.fraud;
import java.io.IOException;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;
public class creditcardDataAnalysis {
	public static void main(String args[])
	{
		try {
			Table creditcard_data= Table.read().csv("C:\\Users\\koush\\eclipse-workspace\\creditcard.fraud\\src\\main\\java\\creditcard\\fraud\\creditcard.csv");

			System.out.println("Datase has: "+creditcard_data.shape());
			System.out.println(creditcard_data.structure());
			System.out.println(creditcard_data.summary());
			System.out.println(creditcard_data.missingValueCounts());	
			System.out.println(creditcard_data.first(10));
			System.out.println(creditcard_data.last(10));
			
			System.out.println("DATASET null : "+creditcard_data.dropRowsWithMissingValues() );
			System.out.println(creditcard_data.sampleN(200));
			
			Layout layout1 = Layout.builder().title("Distribution Over draft").build();
			HistogramTrace trace1=HistogramTrace.builder(creditcard_data.nCol("v11")).build();
			Plot.show(new Figure(layout1,trace1));
			
			Layout layout2 = Layout.builder().title("Distribution of  Credit usage").build();
			HistogramTrace trace2 = HistogramTrace.builder(creditcard_data.nCol("v12")).build();
		    Plot.show(new Figure(layout2, trace2));
		    
		    Layout layout3 = Layout.builder().title("Distribution of Credit history").build();
		    HistogramTrace trace3 = HistogramTrace.builder(creditcard_data.nCol("v13")).build();
		    Plot.show(new Figure(layout3, trace3));
			
		    Layout layout4 = Layout.builder().title("Credit usage by Purpose ").build();
		    BoxTrace trace4 =BoxTrace.builder(creditcard_data.categoricalColumn("v14"), creditcard_data.nCol("v2")).build();
		    Plot.show(new Figure(layout4, trace4));
			
			IntColumn sc = (IntColumn) creditcard_data.column("Class");
			System.out.println(sc);		
			
			Table result = creditcard_data.dropDuplicateRows();
			System.out.println(result);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
