package fil.coo;


public class Student
{
	/*
	 * create a new Student profile
	 */


	private String Name;
	private String Id;
	/**
	* get the Name
	*@param the Name
	*@param Id
	*/
    public Student (String Name , String Id)
    {
        this.Name = Name ;
        this.Id = Id ;
    }
    /**
	* get the Name
	*@return the Name
	*/

    public String get_Name() {

    	return this.Name ;

    }
    /**
	* get the Id

	*@return the Id
	*/

    public String get_Id() {
    	return this.Id;

    }
    /**
	* set the Name
	*@param s new Name

	*/

    public void set_Name(String s) {
    	this.Name = s ;
    }
    /**
	* set the Id
	*@param new Id
	*@return the cell of index
	*/

    public void set_Id(String p) {
    	this.Id = p ;
    }
    /**
	* compare two Student
	*@param Student to compare with
	*@return True if it's the Same Student , false otherwise
	*/

    public boolean Equals(Object x) {
    	if (x instanceof Student){
    		Student Others = (Student) x;
    		return this.Name.equals(Others.get_Name()) && this.Id.equals( Others.get_Id());
    	}
    	return false ;

    }


}
