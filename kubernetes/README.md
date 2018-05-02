# Amazon RDS Installation Notes

```bash
aws rds describe-db-instances

aws rds describe-db-instances \
  --query 'DBInstances[*].{Id:DBInstanceIdentifier,Status:DBInstanceStatus}'

aws rds stop-db-instance \
  --db-instance-identifier elections-dev

aws rds delete-db-instance \
  --db-instance-identifier elections-dev \
  --skip-final-snapshot
```

```bash
kubectl -n dev run curl --image=radial/busyboxplus:curl -i --tty
```
