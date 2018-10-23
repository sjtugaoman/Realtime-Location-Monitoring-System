package demo.task;

import demo.model.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LocationSimulator implements Runnable{
    private long id;

    private AtomicBoolean cancel = new AtomicBoolean();

    private double speedInMps;

    private boolean shouldMove;
    private boolean exportPositionToMessaging = true;
    private Integer reportInterval = 500;

    private PositionInfo positionInfo;

    private List<Leg> legs;
    private RunnerStatus runnerStatus = RunnerStatus.NONE;
    private String runningId;

    private Point startPoint;
    private Date executionStartTime;

    private MedicalInfo medicalInfo;


    public LocationSimulator(GpsSimulatorRequest gpsSimulatorRequest) {
        this.shouldMove = gpsSimulatorRequest.isMove();
        this.exportPositionToMessaging = gpsSimulatorRequest.isExportPositionsToMessaging();
        this.setSpeed(gpsSimulatorRequest.getSpeed());
        this.reportInterval = gpsSimulatorRequest.getReportInterval();

        this.runningId = gpsSimulatorRequest.getRunningId();
        this.runnerStatus = gpsSimulatorRequest.getRunnerStatus();
        this.medicalInfo = gpsSimulatorRequest.getMedicalInfo();
    }

    public void setSpeed(double speed) {
        this.speedInMps = speed;
    }

    @Override
    public void run() {

    }
}
