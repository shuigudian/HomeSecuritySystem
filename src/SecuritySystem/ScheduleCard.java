package GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


//import sosafe.dao.DayDao;
//import sosafe.dao.ScheduleDao;
//import sosafe.dao.ServiceDao;

import Model.*;


public class ScheduleCard extends JPanel{
	
	private static final long serialVersionUID = 5020997314853883492L;
	//private final ServiceDao serviceDao = new ServiceDao(null);
	//private final ScheduleDao scheduleDao = new ScheduleDao(null);
	//private final DayDao dayDao = new DayDao(null);
	private Service service = null;
	private List<Schedule> schedules = null;
	private String serviceCode = null;
	
	public ScheduleCard() {
	    {
		//Get Service
 //   	List<Service> services = serviceDao.getServices();
  //  	if(services != null && services.size() > 0) {
    //		service = services.get(0);
    		serviceCode = service.getServiceCode();
        	System.out.println("\nRetrieved service = " + service.getServiceCode());
    	}
    	//Get Schedules by Service Code
    //    schedules = scheduleDao.getSchedulesByServiceCode(service.getServiceCode());


		this.setLayout(null);
		JLabel activationSchedule = new JLabel("Activation Schedule:");
        JLabel timeLabel = new JLabel("Enter Time:");
        JLabel fromTimeLabel = new JLabel("From:");
        JLabel toTimeLabel = new JLabel("To:");

        JButton saveBtn = new JButton("Save");
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel model1 = new SpinnerDateModel();
        model1.setValue(calendar.getTime());

        SpinnerDateModel model2 = new SpinnerDateModel();
        model2.setValue(calendar.getTime());

        final JSpinner spinner1From = new JSpinner(model1);
        JSpinner.DateEditor editor1From = new JSpinner.DateEditor(spinner1From, "HH:mm:ss");
        DateFormatter formatter1From = (DateFormatter) editor1From.getTextField().getFormatter();
        formatter1From.setAllowsInvalid(false); // this makes what you want
        formatter1From.setOverwriteMode(true);
        spinner1From.setEditor(editor1From);

        final JSpinner spinner1To = new JSpinner(model2);
        JSpinner.DateEditor editor1To = new JSpinner.DateEditor(spinner1To, "HH:mm:ss");
        DateFormatter formatter1To = (DateFormatter) editor1To.getTextField().getFormatter();
        formatter1To.setAllowsInvalid(false); // this makes what you want
        formatter1To.setOverwriteMode(true);
        spinner1To.setEditor(editor1To);
        

		JLabel fromDateLabel = new JLabel("From:");
		JLabel toDateLabel = new JLabel("To:");
		fromDateLabel.setBounds(230, 350, 100, 25);
		toDateLabel.setBounds(500, 350, 100, 25);

		Date fromDate = service.getFromDate();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(fromDate);
		int yearFrom  = cal1.get(Calendar.YEAR);
		int monthFrom = cal1.get(Calendar.MONTH);
		int dayFrom   = cal1.get(Calendar.DAY_OF_MONTH);

		Date toDate = service.getToDate();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(toDate);
		int yearTo  = cal2.get(Calendar.YEAR);
		int monthTo = cal2.get(Calendar.MONTH);
		int dayTo   = cal2.get(Calendar.DAY_OF_MONTH);

		UtilDateModel modelScheduleFrom = new UtilDateModel();
		modelScheduleFrom.setDate(yearFrom, monthFrom, dayFrom);
		modelScheduleFrom.setSelected(true);
		// Need this...
		Properties pScheduleFrom = new Properties();
		pScheduleFrom.put("text.today", "Today");
		pScheduleFrom.put("text.month", "Month");
		pScheduleFrom.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(modelScheduleFrom, pScheduleFrom);
		// Don't know about the formatter, but there it is...
		final JDatePickerImpl scheduleDatePickerFrom = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		scheduleDatePickerFrom.setBounds(280, 350, 150, 35);

		UtilDateModel modelScheduleTo = new UtilDateModel();
		modelScheduleTo.setDate(yearTo, monthTo, dayTo);
		modelScheduleTo.setSelected(true);
		// Need this...
		Properties pScheduleTo = new Properties();
		pScheduleTo.put("text.today", "Today");
		pScheduleTo.put("text.month", "Month");
		pScheduleTo.put("text.year", "Year");
		JDatePanelImpl scheduleDatePanelTo = new JDatePanelImpl(modelScheduleTo, pScheduleTo);
		// Don't know about the formatter, but there it is...
		final JDatePickerImpl scheduleDatePickerTo = new JDatePickerImpl(scheduleDatePanelTo, new DateLabelFormatter());
		scheduleDatePickerTo.setBounds(530, 350, 150, 35);


        this.add(fromDateLabel);
        this.add(scheduleDatePickerFrom);
        this.add(toDateLabel);
        this.add(scheduleDatePickerTo);
        this.add(activationSchedule);
        this.add(timeLabel);
        this.add(fromTimeLabel);
        this.add(spinner1From);
        this.add(toTimeLabel);
        this.add(spinner1To);

      
      this.add (saveBtn);
      
      saveBtn.addActionListener(new ActionListener(){
    	  //Service service = new Service();

          //@Override
          public void actionPerformed(ActionEvent event){
        	  	Calendar calendar = Calendar.getInstance();
        	  	calendar.setTime((Date) spinner1From.getValue());
        	  	int hh1From = calendar.get(Calendar.HOUR_OF_DAY);
        	  	int mm1From = calendar.get(Calendar.MINUTE);
        	  	int ss1From = calendar.get(Calendar.SECOND);

        	  	calendar.setTime((Date) spinner1To.getValue());
          	    int hh1To = calendar.get(Calendar.HOUR_OF_DAY);
        	    int mm1To = calendar.get(Calendar.MINUTE);
        	    int ss1To = calendar.get(Calendar.SECOND);

				Time fromTime1 = new Time(hh1From, mm1From, ss1From);
				Time toTime1 = new Time(hh1To, mm1To, ss1To);
				Schedule myschedule = new Schedule();
				//serviceDao.updateService(service);
//				List<Schedule> schedules = scheduleDao.getSchedulesByServiceId(service.getId());
              myschedule.setFromTime(fromTime1);
              myschedule.setFromTime(toTime1);
	//			scheduleDao.updateSchedule(myschedule);

              Date fromDate = (Date) scheduleDatePickerFrom.getModel().getValue();
              Date toDate = (Date) scheduleDatePickerTo.getModel().getValue();
              myschedule.setFromDay(fromDate);
              myschedule.setToDay(toDate);
				}
      });  
	}

    public class DateLabelFormatter extends AbstractFormatter {

        private static final long serialVersionUID = 2689799580235498501L;
		
		private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                if(cal.getTime() != null) {
                	return dateFormatter.format(cal.getTime());
                }
            }

            return "";
        }

    }
}
