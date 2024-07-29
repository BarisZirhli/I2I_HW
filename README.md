












## Performance Comparison: Relational Database (PostgreSQL) vs. In-Memory Database (Hazelcast)

### Relational Database: PostgreSQL

- **Number of Entries:** 10,000
- **Time to Insert Entries:** 1156.2129 ms
- **Time to Retrieve Entries:** 4.6902 ms

#### Detailed Results

| Operation       | Number of Entries | Time Taken (ms) |
|-----------------|-------------------|-----------------|
| **Insert**      | 10,000            | 1156.2129       |
| **Retrieve**    | 10,000            | 4.6902          |

### In-Memory Database: Hazelcast

- **Number of Entries:** 10,000
- **Time to Insert Entries:** 288.0529 ms
- **Time to Retrieve Entries:** 136.2297 ms

#### Detailed Results

| Operation       | Number of Entries | Time Taken (ms) |
|-----------------|-------------------|-----------------|
| **Insert**      | 10,000            | 288.0529        |
| **Retrieve**    | 10,000            | 136.2297        |

---

### Summary

- **PostgreSQL:** 
  - Insertion took significantly longer compared to Hazelcast.
  - Retrieval was very fast, taking only a small fraction of the time.

- **Hazelcast:** 
  - Insertion was much faster than PostgreSQL.
  - Retrieval took more time compared to PostgreSQL, but still performed efficiently.

---

This detailed comparison highlights the trade-offs between using a traditional relational database and an in-memory database. PostgreSQL shows slower insert times but extremely fast retrieval times, while Hazelcast provides rapid inserts with relatively slower retrieval times.
