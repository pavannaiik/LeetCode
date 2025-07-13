/* Write your T-SQL query statement below */
select product_id from products(nolock)
where low_fats = 'Y' and recyclable = 'Y';