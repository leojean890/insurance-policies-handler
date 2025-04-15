  curl -X POST http://localhost:8080/api/insurancePolicies \
       -H "Content-Type: application/json" \
       -d '{"name": "name1", "status": "ACTIVE", "coverageStartDate": "2025-03-25", "coverageEndDate": "2025-05-25"}'
