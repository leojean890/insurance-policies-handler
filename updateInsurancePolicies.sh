  curl -X PUT http://localhost:8080/api/insurancePolicies/1 \
       -H "Content-Type: application/json" \
       -d '{"name": "name200","status": "INACTIVE", "coverageStartDate": "2025-03-22", "coverageEndDate": "2025-05-22"}'
