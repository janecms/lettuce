package com.lambdaworks.redis.cluster.api.async;

import java.util.List;
import com.lambdaworks.redis.ScriptOutputType;
import com.lambdaworks.redis.RedisFuture;

/**
 * Asynchronous executed commands on a node selection for Scripting.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 3.0
 * @generated by com.lambdaworks.apigenerator.CreateAsyncNodeSelectionClusterApi
 */
public interface NodeSelectionScriptingAsyncCommands<K, V> {

    /**
     * Execute a Lua script server side.
     * 
     * @param script Lua 5.1 script.
     * @param type output type
     * @param keys key names
     * @param <T> expected return type
     * @return script result
     */
    <T> AsyncExecutions<T> eval(String script, ScriptOutputType type, K... keys);

    /**
     * Execute a Lua script server side.
     * 
     * @param script Lua 5.1 script.
     * @param type the type
     * @param keys the keys
     * @param values the values
     * @param <T> expected return type
     * @return script result
     */
    <T> AsyncExecutions<T> eval(String script, ScriptOutputType type, K[] keys, V... values);

    /**
     * Evaluates a script cached on the server side by its SHA1 digest
     * 
     * @param digest SHA1 of the script
     * @param type the type
     * @param keys the keys
     * @param <T> expected return type
     * @return script result
     */
    <T> AsyncExecutions<T> evalsha(String digest, ScriptOutputType type, K... keys);

    /**
     * Execute a Lua script server side.
     * 
     * @param digest SHA1 of the script
     * @param type the type
     * @param keys the keys
     * @param values the values
     * @param <T> expected return type
     * @return script result
     */
    <T> AsyncExecutions<T> evalsha(String digest, ScriptOutputType type, K[] keys, V... values);

    /**
     * Check existence of scripts in the script cache.
     * 
     * @param digests script digests
     * @return List&lt;Boolean&gt; array-reply The command returns an array of integers that correspond to the specified SHA1
     *         digest arguments. For every corresponding SHA1 digest of a script that actually exists in the script cache, an 1
     *         is returned, otherwise 0 is returned.
     */
    AsyncExecutions<List<Boolean>> scriptExists(String... digests);

    /**
     * Remove all the scripts from the script cache.
     * 
     * @return String simple-string-reply
     */
    AsyncExecutions<String> scriptFlush();

    /**
     * Kill the script currently in execution.
     * 
     * @return String simple-string-reply
     */
    AsyncExecutions<String> scriptKill();

    /**
     * Load the specified Lua script into the script cache.
     * 
     * @param script script content
     * @return String bulk-string-reply This command returns the SHA1 digest of the script added into the script cache.
     */
    AsyncExecutions<String> scriptLoad(V script);
}
