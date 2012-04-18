package com.johnson.UnitConverter;

public class UnitConverterMain
{
	private static final String ARG_LENGTH_CM     = "-cm";
	private static final String ARG_LENGTH_METER  = "-m";
	private static final String ARG_LENGTH_KM     = "-km";
	private static final String ARG_LENGTH_INCH   = "-in";
	private static final String ARG_LENGTH_FOOT   = "-ft";
	private static final String ARG_LENGTH_MILE   = "-mi";

	private static final String ARG_WEIGHT_GRAM   = "-g";
	private static final String ARG_WEIGHT_KG     = "-kg";
	private static final String ARG_WEIGHT_POUND  = "-lb";
	private static final String ARG_WEIGHT_OUNCE  = "-oz";

	private static final String ARG_VOLUME_LITER  = "-l";
	private static final String ARG_VOLUME_GALLON = "-ga";
	private static final String ARG_VOLUME_CUP    = "-cp";
	private static final String ARG_VOLUME_PINT   = "-p";
	private static final String ARG_VOLUME_QUART  = "-q";
	private static final String ARG_VOLUME_OUNCE  = "-foz";

	private static final String ARG_TEMP_CELSIUS    = "-c";
	private static final String ARG_TEMP_FAHRENHEIT = "-f";

	private static final String ARG_MILEAGE_MPG   = "-mpg";
	private static final String ARG_MILEAGE_LPK   = "-lpk";

	private static final String ARG_AREA_SQ_METER = "-m2";
	private static final String ARG_AREA_SQ_KM    = "-km2";
	private static final String ARG_AREA_SQ_INCH  = "-in2";
	private static final String ARG_AREA_SQ_FOOT  = "-ft2";
	private static final String ARG_AREA_SQ_YARD  = "-yd2";
	private static final String ARG_AREA_SQ_MILE  = "-mi2";
	private static final String ARG_AREA_ACRE     = "-ac";
	private static final String ARG_AREA_HECTARE  = "-ha";

	private static final String ARG_HELP_H        = "-h";
	private static final String ARG_HELP          = "-help";
	private static final String ARG_HELP_QMARK    = "-?";

	private static class Input
	{
		public String measurementType;
		public String measurementUnit;
		public double value;
	}

	//
	//	 Simple Command line parser
	//
	private static boolean parseCommandLine(final String[] args, Input input) throws Exception
	{
		if(args.length == 1)
		{
			if(ARG_HELP.equals(args[0]) || ARG_HELP_H.equals(args[0]) || ARG_HELP_QMARK.equals(args[0]))
		    {
		      printUsage();
		      return false;
		    }
			else
			{
				throw new Exception("Invalid command line argument: " + args[0] );
			}
		}

		if(args.length > 2)
		{
			throw new Exception("Invalid number of command line arguments: " + args.length );
		}

		for(int i = 0; i < args.length; i++)
		{
			String argv = args[i];
			input.value = Double.parseDouble(args[++i]);

			//
			// Lengths
			//

			if(ARG_LENGTH_CM.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_LENGTH;
				input.measurementUnit = MeasurementFactory.UNIT_LENGTH_CM;
			}
			else if(ARG_LENGTH_METER.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_LENGTH;
				input.measurementUnit = MeasurementFactory.UNIT_LENGTH_METER;
			}
			else if(ARG_LENGTH_KM.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_LENGTH;
				input.measurementUnit = MeasurementFactory.UNIT_LENGTH_KM;
			}
			else if(ARG_LENGTH_INCH.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_LENGTH;
				input.measurementUnit = MeasurementFactory.UNIT_LENGTH_INCH;
			}
			else if(ARG_LENGTH_FOOT.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_LENGTH;
				input.measurementUnit = MeasurementFactory.UNIT_LENGTH_FOOT;
			}
			else if(ARG_LENGTH_MILE.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_LENGTH;
				input.measurementUnit = MeasurementFactory.UNIT_LENGTH_MILE;
			}

			//
			// Weights
			//
			else if(ARG_WEIGHT_GRAM.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_WEIGHT;
				input.measurementUnit = MeasurementFactory.UNIT_WEIGHT_GRAM;
			}
			else if(ARG_WEIGHT_KG.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_WEIGHT;
				input.measurementUnit = MeasurementFactory.UNIT_WEIGHT_KG;
			}
			else if(ARG_WEIGHT_POUND.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_WEIGHT;
				input.measurementUnit = MeasurementFactory.UNIT_WEIGHT_POUND;
			}
			else if(ARG_WEIGHT_OUNCE.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_WEIGHT;
				input.measurementUnit = MeasurementFactory.UNIT_WEIGHT_OUNCE;
			}

			//
			// Volumes
			//
			else if(ARG_VOLUME_LITER.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_VOLUME;
				input.measurementUnit = MeasurementFactory.UNIT_VOLUME_LITER;
			}
			else if(ARG_VOLUME_GALLON.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_VOLUME;
				input.measurementUnit = MeasurementFactory.UNIT_VOLUME_GALLON;
			}
			else if(ARG_VOLUME_CUP.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_VOLUME;
				input.measurementUnit = MeasurementFactory.UNIT_VOLUME_CUP;
			}
			else if(ARG_VOLUME_OUNCE.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_VOLUME;
				input.measurementUnit = MeasurementFactory.UNIT_VOLUME_OUNCE;
			}
			else if(ARG_VOLUME_PINT.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_VOLUME;
				input.measurementUnit = MeasurementFactory.UNIT_VOLUME_PINT;
			}
			else if(ARG_VOLUME_QUART.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_VOLUME;
				input.measurementUnit = MeasurementFactory.UNIT_VOLUME_QUART;
			}

			//
			// Temperatures
			//
			else if(ARG_TEMP_CELSIUS.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_TEMPERATURE;
				input.measurementUnit = MeasurementFactory.UNIT_TEMP_CELSIUS;
			}
			else if(ARG_TEMP_FAHRENHEIT.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_TEMPERATURE;
				input.measurementUnit = MeasurementFactory.UNIT_TEMP_FAHRENHEIT;
			}

			//
			// Mileage
			//
			else if(ARG_MILEAGE_LPK.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_MILEAGE;
				input.measurementUnit = MeasurementFactory.UNIT_MILEAGE_LPK;
			}
			else if(ARG_MILEAGE_MPG.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_MILEAGE;
				input.measurementUnit = MeasurementFactory.UNIT_MILEAGE_MPG;
			}

			//
			// Area
			//
			else if(ARG_AREA_SQ_METER.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_SQ_METER;
			}
			else if(ARG_AREA_SQ_KM.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_SQ_KM;
			}
			else if(ARG_AREA_SQ_INCH.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_SQ_INCH;
			}
			else if(ARG_AREA_SQ_FOOT.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_SQ_FOOT;
			}
			else if(ARG_AREA_SQ_YARD.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_SQ_YARD;
			}
			else if(ARG_AREA_SQ_MILE.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_SQ_MILE;
			}
			else if(ARG_AREA_ACRE.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_ACRE;
			}
			else if(ARG_AREA_HECTARE.equals(argv))
			{
				input.measurementType = MeasurementFactory.MEASURE_AREA;
				input.measurementUnit = MeasurementFactory.UNIT_AREA_HECTARE;
			}

			//
			// Other args
			//
		    else
		    {
		      throw new Exception("Invalid command line argument: " + argv );
		    }
		}
		
		return true;
	}

	private static void printUsage()
	{
	  System.out.println(
		   "\nUsage:\n" +
		   "\t If started with no arguments, the GUI will be launched\n" +
	       "Specify one of the following and the rest of the units of that measurement will be displayed\n" +

	       "\nLengths:\n\t" +
	       ARG_LENGTH_CM     + "\t centimeters\n\t" +
	       ARG_LENGTH_METER  + "\t meters\n\t" +
	       ARG_LENGTH_KM     + "\t kilometers\n\t" +
	       ARG_LENGTH_INCH   + "\t inches\n\t" +
	       ARG_LENGTH_FOOT   + "\t feet\n\t" +
	       ARG_LENGTH_MILE   + "\t miles\n" +

	       "\nWeights:\n\t" +
	       ARG_WEIGHT_GRAM   + "\t grams\n\t" +
	       ARG_WEIGHT_KG     + "\t kilograms\n\t" +
	       ARG_WEIGHT_POUND  + "\t pounds\n\t" +
	       ARG_WEIGHT_OUNCE  + "\t ounces\n" +

	       "\nVolumes:\n\t" +
	       ARG_VOLUME_LITER  + "\t liters\n\t" +
	       ARG_VOLUME_GALLON + "\t gallons\n\t" +
	       ARG_VOLUME_OUNCE  + "\t fluid ounces\n\t" +
	       ARG_VOLUME_PINT   + "\t pints\n\t" +
	       ARG_VOLUME_QUART  + "\t quarts\n\t" +
	       ARG_VOLUME_CUP    + "\t cups\n" +

	       "\nTemperatures:\n\t" +
	       ARG_TEMP_CELSIUS     + "\t degrees celsius\n\t" +
	       ARG_TEMP_FAHRENHEIT  + "\t degrees fahrenheit\n\t" +
	       
	       "\nGas Mileage:\n\t" +
	       ARG_MILEAGE_MPG + "\t miles per gallon\n\t" +
	       ARG_MILEAGE_LPK + "\t liters per 100 km\n" +

	       "\nArea:\n\t" +
	       ARG_AREA_SQ_METER + "\t square meters\n\t" +
	       ARG_AREA_HECTARE  + "\t hectares\n\t" +
	       ARG_AREA_SQ_KM    + "\t square kilo meters\n\t" +
	       ARG_AREA_SQ_INCH  + "\t square inches\n\t" +
	       ARG_AREA_SQ_FOOT  + "\t square feet\n\t" +
	       ARG_AREA_SQ_YARD  + "\t square yards\n\t" +
	       ARG_AREA_SQ_MILE  + "\t square miles\n\t" +
	       ARG_AREA_ACRE     + "\t acres\n" +

	       "\nOther Commands:\n\t" +
	       ARG_HELP_H + "\t Display this message, same as: " + ARG_HELP + " and " + ARG_HELP_QMARK + "\n");
	}

	public static void main(String[] args) 
	{
		MeasurementFactory factory = MeasurementFactory.instance();
		factory.load();

		// Launch the gui if no args set
		if(args.length == 0)
		{
			UnitConverterGui gui = new UnitConverterGui(factory);
			gui.init();
			return;
		}

		// otherwise parse the command line args
		Input input = new Input();
		try
		{
			if(!parseCommandLine(args, input))
			{
				return;
			}
		}
		catch(Exception e)
		{
			System.err.println("Error parsing command line: " + e.getMessage());
			printUsage();
			return;
		}

		Measurement m = factory.getMeasurement(input.measurementType);
		if(m == null)
		{
			System.err.println("The measurement type does not exist: " + input.measurementType);
			return;
		}

		MeasurementUnit mu = m.findUnit(input.measurementUnit);
		if(mu == null)
		{
			System.err.println("The measurement unit does not exist: " + input.measurementUnit);
			return;
		}

		System.out.println("Converting: " + input.measurementType + "[" + input.measurementUnit + "] " + input.value);
		System.out.println(m.toString(mu.convertToReference(input.value)));
	}
}