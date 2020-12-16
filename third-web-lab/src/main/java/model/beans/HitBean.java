package model.beans;

import dao.Dao;
import hibernateEntity.PointEntity;
import lombok.Data;
import service.CheckHitPoint;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@ApplicationScoped
@ManagedBean(name = "hitBean")
public class HitBean {

    private boolean x1, x2, x3,
            x4, x5, x6;
    private double x;
    private List<Double> XValues;
    private List<PointEntity> results = new LinkedList<>();

    private double y;
    private int r;
    private boolean hit;

    @Inject
    private Dao<PointEntity> pointEntityDao;

    public void submitHitPointForm() {
        setXValues();
        for (Double x : XValues) {
            hit = CheckHitPoint.checkHit(x, y, r);
            savePoint(x, y, r, hit);
        }
    }

    public void submitHitPointDiagram() {
        hit = CheckHitPoint.checkHit(x, y, r);
        savePoint(x, y, r, hit);
    }

    private void setXValues() {
        this.XValues = new ArrayList<Double>() {{
            if (x1) add((double) -2);
            if (x2) add(-1.5);
            if (x3) add((double) -1);
            if (x4) add(-0.5);
            if (x5) add((double) 0);
            if (x6) add(0.5);
        }};
    }

    private void savePoint(double x, double y, int r, boolean hit) {
        PointEntity pointEntity = new PointEntity();
        pointEntity.setX(x);
        pointEntity.setY(y);
        pointEntity.setR(r);
        pointEntity.setHit(hit);
        results.add(pointEntity);
        pointEntityDao.save(pointEntity);
    }
}
