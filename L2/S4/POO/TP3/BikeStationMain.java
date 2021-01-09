public class BikeStationMain{
    public static void main(String[] args){
	BikeStation timo = new BikeStation("Timoleon",10); //une station de location de vélos de nom Timoleon et qui peut accueillir 10 v´elos
	Bike first = new Bike("b001" , BikeModel.CLASSICAL);
	Bike second = new Bike("b002" , BikeModel.ELECTRIC);

	timo.dropBike(first);
	timo.dropBike(second);

    if (args.length<1){
    	System.out.println("Un argument est nécéssaire.");
	}
    else{
	    int  n= Integer.parseInt( args[0]);
        Bike BikeChose = timo.takeBike(n);
		if(BikeChose == null){
			System.out.println("Il n'y a pas de vélo a cette emplacement");
		}
		else{
	    	System.out.println(BikeChose.toString());
	    	System.out.println(BikeChose.price());
	    }

    }
}
}
