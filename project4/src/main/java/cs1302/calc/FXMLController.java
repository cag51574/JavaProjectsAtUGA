import cs1302.calc.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class FXMLController {
    private Boolean hideBinary = false;
    private Boolean useRec = false;
    private IterativeMath iter = new IterativeMath();
    private RecursiveMath rec  = new RecursiveMath();
    private String expression;
    private String infix[];
    private String postfix[];
    private String binString[] = new String[32];
    private int result;
    @FXML private Label input, output;
    @FXML private Label bin31, bin30, bin29, bin28, bin27, bin26, bin25, bin24, bin23, bin22;
    @FXML private Label bin21, bin20, bin19, bin18, bin17, bin16, bin15, bin14, bin13, bin12;
    @FXML private Label bin11, bin10, bin9, bin8, bin7, bin6, bin5, bin4, bin3, bin2, bin1, bin0;
    @FXML private Label lab31, lab30, lab29, lab28, lab27, lab26, lab25, lab24, lab23, lab22;
    @FXML private Label lab21, lab20, lab19, lab18, lab17, lab16, lab15, lab14, lab13, lab12;
    @FXML private Label lab11, lab10, lab9, lab8, lab7, lab6, lab5, lab4, lab3, lab2, lab1, lab0;
    @FXML private Button recBtn;


    /**
     * The zero button on the calculator
     */
    @FXML protected void zeroBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("0");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "0");
        }else{
            input.setText(input.getText() + " " + "0");
        }
    }

    /**
     * The one button on the calculator
     */
    @FXML protected void oneBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("1");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "1");
        }else{
            input.setText(input.getText() + " " + "1");
        }
    }

    /**
     * The two button on the calculator
     */
    @FXML protected void twoBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("2");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "2");
        }else{
            input.setText(input.getText() + " " + "2");
        }
    }

    /**
     * The three button on the calculator
     */
    @FXML protected void threeBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("3");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "3");
        }else{
            input.setText(input.getText() + " " + "3");
        }
    }

    /**
     * The four button on the calculator
     */
    @FXML protected void fourBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("4");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "4");
        }else{
            input.setText(input.getText() + " " + "4");
        }
    }

    /**
     * The five button on the calculator
     */
    @FXML protected void fiveBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("5");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "5");
        }else{
            input.setText(input.getText() + " " + "5");
        }
    }

    /**
     * The six button on the calculator
     */
    @FXML protected void sixBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("6");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "6");
        }else{
            input.setText(input.getText() + " " + "6");
        }
    }

    /**
     * The seven button on the calculator
     */
    @FXML protected void sevenBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("7");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "7");
        }else{
            input.setText(input.getText() + " " + "7");
        }
    }

    /**
     * The eight button on the calculator
     */
    @FXML protected void eightBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("8");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "8");
        }else{
            input.setText(input.getText() + " " + "8");
        }
    }

    /**
     * The nine button on the calculator
     */
    @FXML protected void nineBtn(ActionEvent event) {
        String in = input.getText();
        if(in == ""){
            input.setText("9");
        }else if(in.substring(in.length()-1).matches("\\d+$")){
            input.setText(input.getText() + "9");
        }else{
            input.setText(input.getText() + " " + "9");
        }
    }

    /**
     * The divide button on the calculator
     */
    @FXML protected void divBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "/");
        }else{
            input.setText("/");
        }
    }

    /**
     * The multiply button on the calculator
     */
    @FXML protected void multBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "*");
        }else{
            input.setText("*");
        }
    }

    /**
     * The minus zerobutton on the calculator
     */
    @FXML protected void minBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "-");
        }else{
            input.setText("-");
        }
    }

    /**
     * The add button on the calculator
     */
    @FXML protected void addBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "+");
        }else{
            input.setText("+");
        }
    }

    /**
     * The factorial button on the calculator
     */
    @FXML protected void factBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "!");
        }else{
            input.setText("!");
        }
    }

    /**
     * The exponentiation button on the calculator
     */
    @FXML protected void expBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "^");
        }else{
            input.setText("^");
        }
    }

    /**
     * The left bit shift button on the calculator
     */
    @FXML protected void lShiftBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + "<<");
        }else{
            input.setText("<<");
        }
    }

    /**
     * The right bit shift button on the calculator
     */
    @FXML protected void rShiftBtn(ActionEvent event) {
        if(input.getText() != ""){
            input.setText(input.getText() + " " + ">>");
        }else{
            input.setText(">>");
        }
    }

    /**
     * The equals button on the calculator, changes binary buttons to reflect result.
     */
    @FXML protected void equalBtn(ActionEvent event) {
        expression = input.getText();
        infix = expression.split(" ");
        postfix = ReversePolishNotation.infixToPostfix(infix);
        int result;
        if(useRec == false){
            result = ReversePolishNotation.evaluate(iter, postfix);
        }else{
            result = ReversePolishNotation.evaluate(rec, postfix);
        }
        output.setText(Integer.toString(result));
        String binaryStr[] = Integer.toBinaryString(result).split("");

        for(int i = 0; i < binString.length;i++){
            try{
                binString[i] = binaryStr[binaryStr.length-i];
            }catch(Exception ex){binString[i] = "0";}
        }
        if(hideBinary == false){
        bin0.setText(binString[0]);
        bin1.setText(binString[1]);
        bin2.setText(binString[2]);
        bin3.setText(binString[3]);
        bin4.setText(binString[4]);
        bin5.setText(binString[5]);
        bin6.setText(binString[6]);
        bin7.setText(binString[7]);
        bin8.setText(binString[8]);
        bin9.setText(binString[9]);
        bin10.setText(binString[10]);
        bin11.setText(binString[11]);
        bin12.setText(binString[12]);
        bin13.setText(binString[13]);
        bin14.setText(binString[14]);
        bin15.setText(binString[15]);
        bin16.setText(binString[16]);
        bin17.setText(binString[17]);
        bin18.setText(binString[18]);
        bin19.setText(binString[19]);
        bin20.setText(binString[20]);
        bin21.setText(binString[21]);
        bin22.setText(binString[22]);
        bin23.setText(binString[23]);
        bin24.setText(binString[24]);
        bin25.setText(binString[25]);
        bin26.setText(binString[26]);
        bin27.setText(binString[27]);
        bin28.setText(binString[28]);
        bin29.setText(binString[29]);
        bin30.setText(binString[30]);
        bin31.setText(binString[31]);
        }
    }

    /**
     * The hide binary button on the calculator
     */
    @FXML protected void hideBinaryBtn(ActionEvent event) {
        if(hideBinary == false){
            hideBinary = true;
            bin0.setText("");
            bin1.setText("");
            bin2.setText("");
            bin3.setText("");
            bin4.setText("");
            bin5.setText("");
            bin6.setText("");
            bin7.setText("");
            bin8.setText("");
            bin9.setText("");
            bin10.setText("");
            bin11.setText("");
            bin12.setText("");
            bin13.setText("");
            bin14.setText("");
            bin15.setText("");
            bin16.setText("");
            bin17.setText("");
            bin18.setText("");
            bin19.setText("");
            bin20.setText("");
            bin21.setText("");
            bin22.setText("");
            bin23.setText("");
            bin24.setText("");
            bin25.setText("");
            bin26.setText("");
            bin27.setText("");
            bin28.setText("");
            bin29.setText("");
            bin30.setText("");
            bin31.setText("");
            lab0.setText("");
            lab1.setText("");
            lab2.setText("");
            lab3.setText("");
            lab4.setText("");
            lab5.setText("");
            lab6.setText("");
            lab7.setText("");
            lab8.setText("");
            lab9.setText("");
            lab10.setText("");
            lab11.setText("");
            lab12.setText("");
            lab13.setText("");
            lab14.setText("");
            lab15.setText("");
            lab16.setText("");
            lab17.setText("");
            lab18.setText("");
            lab19.setText("");
            lab20.setText("");
            lab21.setText("");
            lab22.setText("");
            lab23.setText("");
            lab24.setText("");
            lab25.setText("");
            lab26.setText("");
            lab27.setText("");
            lab28.setText("");
            lab29.setText("");
            lab30.setText("");
            lab31.setText("");
        }else{
            hideBinary = false;
            bin0.setText("0");
            bin1.setText("0");
            bin2.setText("0");
            bin3.setText("0");
            bin4.setText("0");
            bin5.setText("0");
            bin6.setText("0");
            bin7.setText("0");
            bin8.setText("0");
            bin9.setText("0");
            bin10.setText("0");
            bin11.setText("0");
            bin12.setText("0");
            bin13.setText("0");
            bin14.setText("0");
            bin15.setText("0");
            bin16.setText("0");
            bin17.setText("0");
            bin18.setText("0");
            bin19.setText("0");
            bin20.setText("0");
            bin21.setText("0");
            bin22.setText("0");
            bin23.setText("0");
            bin24.setText("0");
            bin25.setText("0");
            bin26.setText("0");
            bin27.setText("0");
            bin28.setText("0");
            bin29.setText("0");
            bin30.setText("0");
            bin31.setText("0");
            lab0.setText("0");
            lab1.setText("1");
            lab2.setText("2");
            lab3.setText("3");
            lab4.setText("4");
            lab5.setText("5");
            lab6.setText("6");
            lab7.setText("7");
            lab8.setText("8");
            lab9.setText("9");
            lab10.setText("10");
            lab11.setText("11");
            lab12.setText("12");
            lab13.setText("13");
            lab14.setText("14");
            lab15.setText("15");
            lab16.setText("16");
            lab17.setText("17");
            lab18.setText("18");
            lab19.setText("19");
            lab20.setText("20");
            lab21.setText("21");
            lab22.setText("22");
            lab23.setText("23");
            lab24.setText("24");
            lab25.setText("25");
            lab26.setText("26");
            lab27.setText("27");
            lab28.setText("28");
            lab29.setText("29");
            lab30.setText("30");
            lab31.setText("31");
        }
    }

    /**
     * The zero button on the calculator
     */
    @FXML protected void useRecursionBtn(ActionEvent event) {
        if(recBtn.getText().equals("Use Recursion")){
            recBtn.setText("Use Iteration");
            useRec = true;
        }else{
            recBtn.setText("Use Recursion");
            useRec = false;
        }

    }

    /**
     * The zero button on the calculator
     */
    @FXML protected void delBtn(ActionEvent event) {
        String in = input.getText();
        if(in.equals("") || in.length() == 1){
            input.setText("");
        }else if(in.substring(in.length()-2,in.length()-1).equals(" ")){
            input.setText(in.substring(0,in.length()-2));
        }else if(in.equals("<<")){
            input.setText("");
        }else if(in.equals(">>")){
            input.setText("");
        }else if((in.length() > 2) && in.substring(in.length()-3,in.length()-0).equals(" >>")){
            input.setText(in.substring(0,in.length()-3));
        }else if((in.length() > 2) && in.substring(in.length()-3,in.length()-0).equals(" <<")){
            input.setText(in.substring(0,in.length()-3));
        }else{
            input.setText(in.substring(0,in.length()-1));
        }
    }

    /**
     * The zero button on the calculator
     */
    @FXML protected void clearBtn(ActionEvent event) {
        input.setText("");
        output.setText("0");
	if(hideBinary == false){
            bin0.setText("0");
            bin1.setText("0");
            bin2.setText("0");
            bin3.setText("0");
            bin4.setText("0");
            bin5.setText("0");
            bin6.setText("0");
            bin7.setText("0");
            bin8.setText("0");
            bin9.setText("0");
            bin10.setText("0");
            bin11.setText("0");
            bin12.setText("0");
            bin13.setText("0");
            bin14.setText("0");
            bin15.setText("0");
            bin16.setText("0");
            bin17.setText("0");
            bin18.setText("0");
            bin19.setText("0");
            bin20.setText("0");
            bin21.setText("0");
            bin22.setText("0");
            bin23.setText("0");
            bin24.setText("0");
            bin25.setText("0");
            bin26.setText("0");
            bin27.setText("0");
            bin28.setText("0");
            bin29.setText("0");
            bin30.setText("0");
            bin31.setText("0");
	}
    }

    /**
     * The following are all the binary toggles.
     */
    @FXML protected void bin31e(MouseEvent event) {
        if(bin31.getText().equals("0")){
            bin31.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,31);
            output.setText(Integer.toString(o));
        }else{
            bin31.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,31);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin30e(MouseEvent event) {
        if(bin30.getText().equals("0")){
            bin30.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,30);
            output.setText(Integer.toString(o));
        }else{
            bin30.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,30);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin29e(MouseEvent event) {
        if(bin29.getText().equals("0")){
            bin29.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,29);
            output.setText(Integer.toString(o));
        }else{
            bin29.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,29);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin28e(MouseEvent event) {
        if(bin28.getText().equals("0")){
            bin28.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,28);
            output.setText(Integer.toString(o));
        }else{
            bin28.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,28);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin27e(MouseEvent event) {
        if(bin27.getText().equals("0")){
            bin27.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,27);
            output.setText(Integer.toString(o));
        }else{
            bin27.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,27);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin26e(MouseEvent event) {
        if(bin26.getText().equals("0")){
            bin26.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,26);
            output.setText(Integer.toString(o));
        }else{
            bin26.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,26);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin25e(MouseEvent event) {
        if(bin25.getText().equals("0")){
            bin25.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,25);
            output.setText(Integer.toString(o));
        }else{
            bin25.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,25);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin24e(MouseEvent event) {
        if(bin24.getText().equals("0")){
            bin24.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,24);
            output.setText(Integer.toString(o));
        }else{
            bin24.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,24);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin23e(MouseEvent event) {
        if(bin23.getText().equals("0")){
            bin23.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,23);
            output.setText(Integer.toString(o));
        }else{
            bin23.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,23);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin22e(MouseEvent event) {
        if(bin22.getText().equals("0")){
            bin22.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,22);
            output.setText(Integer.toString(o));
        }else{
            bin22.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,22);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin21e(MouseEvent event) {
        if(bin21.getText().equals("0")){
            bin21.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,21);
            output.setText(Integer.toString(o));
        }else{
            bin21.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,21);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin20e(MouseEvent event) {
        if(bin20.getText().equals("0")){
            bin20.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,20);
            output.setText(Integer.toString(o));
        }else{
            bin20.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,20);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin19e(MouseEvent event) {
        if(bin19.getText().equals("0")){
            bin19.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,19);
            output.setText(Integer.toString(o));
        }else{
            bin19.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,19);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin18e(MouseEvent event) {
        if(bin18.getText().equals("0")){
            bin18.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,18);
            output.setText(Integer.toString(o));
        }else{
            bin18.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,18);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin17e(MouseEvent event) {
        if(bin17.getText().equals("0")){
            bin17.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,17);
            output.setText(Integer.toString(o));
        }else{
            bin17.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,17);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin16e(MouseEvent event) {
        if(bin16.getText().equals("0")){
            bin16.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,16);
            output.setText(Integer.toString(o));
        }else{
            bin16.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,16);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin15e(MouseEvent event) {
        if(bin15.getText().equals("0")){
            bin15.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,15);
            output.setText(Integer.toString(o));
        }else{
            bin15.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,15);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin14e(MouseEvent event) {
        if(bin14.getText().equals("0")){
            bin14.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,14);
            output.setText(Integer.toString(o));
        }else{
            bin14.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,14);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin13e(MouseEvent event) {
        if(bin13.getText().equals("0")){
            bin13.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,13);
            output.setText(Integer.toString(o));
        }else{
            bin13.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,13);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin12e(MouseEvent event) {
        if(bin12.getText().equals("0")){
            bin12.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,12);
            output.setText(Integer.toString(o));
        }else{
            bin12.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,12);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin11e(MouseEvent event) {
        if(bin11.getText().equals("0")){
            bin11.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,11);
            output.setText(Integer.toString(o));
        }else{
            bin11.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,11);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin10e(MouseEvent event) {
        if(bin10.getText().equals("0")){
            bin10.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,10);
            output.setText(Integer.toString(o));
        }else{
            bin10.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,10);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin9e(MouseEvent event) {
        if(bin9.getText().equals("0")){
            bin9.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,9);
            output.setText(Integer.toString(o));
        }else{
            bin9.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,9);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin8e(MouseEvent event) {
        if(bin8.getText().equals("0")){
            bin8.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,8);
            output.setText(Integer.toString(o));
        }else{
            bin8.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,8);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin7e(MouseEvent event) {
        if(bin7.getText().equals("0")){
            bin7.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,7);
            output.setText(Integer.toString(o));
        }else{
            bin7.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,7);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin6e(MouseEvent event) {
        if(bin6.getText().equals("0")){
            bin6.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,6);
            output.setText(Integer.toString(o));
        }else{
            bin6.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,6);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin5e(MouseEvent event) {
        if(bin5.getText().equals("0")){
            bin5.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,5);
            output.setText(Integer.toString(o));
        }else{
            bin5.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,5);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin4e(MouseEvent event) {
        if(bin4.getText().equals("0")){
            bin4.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,4);
            output.setText(Integer.toString(o));
        }else{
            bin4.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,4);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin3e(MouseEvent event) {
        if(bin3.getText().equals("0")){
            bin3.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,3);
            output.setText(Integer.toString(o));
        }else{
            bin3.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,3);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin2e(MouseEvent event) {
        if(bin2.getText().equals("0")){
            bin2.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,2);
            output.setText(Integer.toString(o));
        }else{
            bin2.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,2);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin1e(MouseEvent event) {
        if(bin1.getText().equals("0")){
            bin1.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,1);
            output.setText(Integer.toString(o));
        }else{
            bin1.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,1);
            output.setText(Integer.toString(o));
        }
    }

    @FXML protected void bin0e(MouseEvent event) {
        if(bin0.getText().equals("0")){
            bin0.setText("1");
            int o = Integer.parseInt(output.getText());
            o = o + (int)java.lang.Math.pow(2,0);
            output.setText(Integer.toString(o));
        }else{
            bin0.setText("0");
            int o = Integer.parseInt(output.getText());
            o = o - (int)java.lang.Math.pow(2,0);
            output.setText(Integer.toString(o));
        }
    }
}                           
