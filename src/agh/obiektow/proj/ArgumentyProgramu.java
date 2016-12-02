package agh.obiektow.proj;

public class ArgumentyProgramu {
	final Boolean czyRozdzial;
	final Boolean czy2Parametry;
	final int arg1, arg2;

	ArgumentyProgramu(String[] args) {
		System.out.println("Argumenty programu: ");
		for (String arg : args)
			System.out.print("\"" + arg + "\" ");
		System.out.print("\n\n");
		
		if (args.length < 3) {
			throw new NumberFormatException();
		} else {
			switch (args[1]) {
			case "-r":
				czyRozdzial=true;
				break;
			case "-a":
				czyRozdzial=false;
				break;
			default:
				throw new NumberFormatException();
			}
			arg1=Integer.valueOf(args[2]);
			if(args.length==4){
				czy2Parametry=true;
				arg2=Integer.valueOf(args[3]);
			}else {
				czy2Parametry=false;
				arg2=-1;
			}
		}
	}
}
