-- (Q9) Product Type Profit Measure Query
-- tables: tpch_part, tpch_supplier, tpch_lineitem, tpch_partsupp, tpch_orders, tpch_nation
/*SELECT
  nation,
  o_year,
  sum(amount) AS sum_profit
FROM (
  SELECT
    n_name                                                          AS nation,
    extract(YEAR FROM o_orderdate)                                  AS o_year,
    l_extendedprice * (1 - l_discount) - ps_supplycost * l_quantity AS amount
  FROM
    tpch_part,
    tpch_supplier,
    tpch_lineitem,
    tpch_partsupp,
    tpch_orders,
    tpch_nation
  WHERE
    s_suppkey = l_suppkey
    AND ps_suppkey = l_suppkey
    AND ps_partkey = l_partkey
    AND p_partkey = l_partkey
    AND o_orderkey = l_orderkey
    AND s_nationkey = n_nationkey
    AND p_name LIKE '%green%'
  ) AS profit
GROUP BY
  nation,
  o_year
ORDER BY
  nation,
  o_year DESC*/

--Disabling because of icarus
select count(*) from tpch_customer