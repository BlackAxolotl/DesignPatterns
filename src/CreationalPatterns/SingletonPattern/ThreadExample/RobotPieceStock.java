package CreationalPatterns.SingletonPattern.ThreadExample;

/**
 * Created by Ricardo Perez Silva on 31.10.2015.
 */
public class RobotPieceStock {

    private volatile static RobotPieceStock _stock = null;

    private RobotPieceStock(){}

    /**
     * Get singleton instance of the robot piece stock.
     * @return RobotPieceStock Singleton instance of the stock of pieces.
     */
    public static RobotPieceStock getStock() {

        if ( _stock == null )
            synchronized (RobotPieceStock.class) {
                if ( _stock == null )
                    _stock = new RobotPieceStock();
            }
        return _stock;
    }

    private static int _wheel = 40;
    private static int _manipulator = 10;
    private static int _bodywork = 5;

    /**
     * Take a wheel from the stock.
     * @return int The number of wheels in stock.
     */
    public static int getWheel() {

        if (_wheel == 0) {
            System.out.println("Wheel stock is empty");
            return 0;
        }
        else{
            _wheel--;
            return _wheel;
        }
    }

    /**
     * Take a manipulator from the stock.
     * @return int The number of manipulators in stock.
     */
    public static int getManipulator() {

        if (_manipulator == 0) {
            System.out.println("Manipulator stock is empty");
            return 0;
        }
        else{
            _manipulator--;
            return _manipulator;
        }
    }

    /**
     * Take a bodywork from the stock.
     * @return int The number of bodywork in stock.
     */
    public static int getBodywork() {

        if (_bodywork == 0) {
            System.out.println("Bodywork stock is empty");
            return 0;
        }
        else{
            _bodywork--;
            return _bodywork;
        }
    }

    /**
     * Add a number of pieces to the wheel stock.
     * @param numOfPieces Number of pieces to be added to the stock.
     */
    public static void setWheel(int numOfPieces) { _wheel = _wheel + numOfPieces; }

    /**
     * Add a number of pieces to the manipulator stock.
     * @param numOfPieces Number of pieces to be added to the stock.
     */
    public static void setManipulator(int numOfPieces) { _manipulator = _manipulator + numOfPieces; }

    /**
     * Add a number of pieces to the bodywork stock.
     * @param numOfPieces Number of pieces to be added to the stock.
     */
    public static void setBodywork(int numOfPieces) { _bodywork = _bodywork + numOfPieces; }
}