-- 获取方法签名特征
local methodKey = KEYS[1]

redis.log(redis.LOG_DEBUG, 'key is ', methodKey)

-- 调用脚本传入的限流大小
local limit = tonumber(ARGV[1])

-- 获取当前流量大小
local count = tonumber(redis.call('get', methodKey) or "0")

-- 判断是否超出限流阈值

if count + 1 > limit then
    -- 拒绝访问
    return false
else
    -- 设置访问的数量 + 1
    redis.call("INCRBY", methodKey, 1)
    redis.call("EXPIRE", methodKey, 1)
    return true
end